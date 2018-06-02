package com.WebShop.controller;

import com.WebShop.dao.CartDao;
import com.WebShop.dao.ProductDao;
import com.WebShop.model.Cart;
import com.WebShop.model.CartItem;
import com.WebShop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("rest/cart")
public class CartController {


    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;



    @RequestMapping(value = "/{cartId",method = RequestMethod.GET)
    public @ResponseBody
    Cart read (@PathVariable(value = "cartId") String cartId){
        return cartDao.read(cartId);
    }

    @RequestMapping(value = "/{cartId",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cardId") String cartId, @RequestBody Cart cart){

        cartDao.update(cartId,cart);
    }

    @RequestMapping(value = "/{cartId",method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cardId") String cartId, @RequestBody Cart cart){

        cartDao.delete(cartId);
    }


    @RequestMapping(value = "/add/{productId}",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productId") String productId, HttpServletRequest request){

        String sessionId=request.getSession(true).getId();

        Cart cart=cartDao.read(sessionId);

        if (cart==null){
            cart=cartDao.create(new Cart(sessionId));
        }

        Product product=productDao.getProductByID(productId);
        if (product==null){
            throw  new IllegalArgumentException(new Exception());
        }

        cart.AddCartItem(new CartItem(product));

        cartDao.update(sessionId,cart);
    }

    @RequestMapping(value = "/remove/{productId}",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable String productId,HttpServletRequest request){
        String sessionId=request.getSession().getId();
        Cart cart=cartDao.read(sessionId);


        if (cart==null){
            cart=cartDao.create(new Cart(sessionId));
        }
        Product product=productDao.getProductByID(productId);
        if (product==null){
            throw new IllegalArgumentException(new Exception());
        }

        cart.RemoveCartItem(new CartItem(product));
        cartDao.update(sessionId,cart);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Illegal request, verify payload")
    public void handleClientErrors(Exception e){

    }  @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,reason = "Server errror")
    public void handleServerError(Exception e){

    }


}
