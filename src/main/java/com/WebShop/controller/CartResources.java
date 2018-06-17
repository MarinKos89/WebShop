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
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rest/cart")
public class CartResources {


    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemService cartItemService;

    @RequestMapping("/{cartID")
    public @ResponseBody
    Cart getCartByID(@PathVariable(value = "cartID")int cartID){

        return cartService.getCartByID(cartID);

    }

    @RequestMapping("/add/{productID}")
    @ResponseStatus
    public void addItem(@PathVariable(value = "productID") int productID, @AuthenticationPrincipal User activeUser)
    {
        Customer customer=customerService.getCustomerByUsername(activeUser.getUsername());
        Cart cart=customer.getCart();
        Product product=productService.getProductByID(productID);
        List<CartItem> cartItems=cart.getCartItemList();

        for (int i=0;i<cartItems.size();i++){
            if (product.getProductID()==cartItems.get(i).getProduct().getProductID()){
                CartItem cartItem=cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItem.setTotalPrice(cartItem.getTotalPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);

                return;
            }
        }

        CartItem cartItem=new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(cartItem.getTotalPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }


    @RequestMapping(value = "/remove/{productID}",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "productID") int productID)
    {
        CartItem cartItem=cartItemService.getCartItemByProductID(productID);
        cartItemService.removeCartItem(cartItem);
    }

    @RequestMapping(value = "/{cartID}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable(value = "cartID") int cartID){
        Cart cart=cartService.getCartByID(cartID);
        cartItemService.removeAllCartItems(cart);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "illegal request")
    public void handleClientError(Exception e){

    }   @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,reason = "Server error")
    public void handleServerError(Exception e){

    }
}
