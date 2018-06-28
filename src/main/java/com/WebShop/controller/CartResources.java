package com.WebShop.controller;

import com.WebShop.model.Cart;
import com.WebShop.model.CartItem;
import com.WebShop.model.Customer;
import com.WebShop.model.Product;
import com.WebShop.service.CartItemService;
import com.WebShop.service.CartService;
import com.WebShop.service.CustomerService;
import com.WebShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "rest/cart")
public class CartResources {


    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;



    @RequestMapping("/{cartID}")
    public @ResponseBody
    Cart getCartByID(@PathVariable(value = "cartID")int cartID){

        return cartService.getCartByID(cartID);

    }

    @RequestMapping(value = "/add/{productID}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productID") int productID)
    {

        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Customer customer = customerService.getCustomerByUsername(user.getUsername());
        Cart cart = customer.getCart();
        Product product = productService.getProductByID(productID);
        List<CartItem> cartItems = cart.getCartItems();

        for (int i=0; i<cartItems.size(); i++) {
            if(product.getProductID()==cartItems.get(i).getProduct().getProductID()){
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);
                return;

            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);


    }


    @RequestMapping(value="/remove/{productId}", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable int productId, HttpServletRequest request) {
        CartItem cartItem = cartItemService.getCartItemByProductID(productId);
        cartItemService.removeCartItem(cartItem);
    }

    @RequestMapping(value = "/cart/removeAllItems/{cartID}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable(value = "cartID") int cartID){
        Cart cart = cartService.getCartByID(cartID);
        cartItemService.removeAllCartItems(cart);
    }

}
