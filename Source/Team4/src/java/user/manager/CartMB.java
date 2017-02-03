package user.manager;

import entities.Carts;
import entities.Services;
import helper.SessionManaged;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

@ManagedBean
@ViewScoped
public class CartMB implements Serializable {

    private HashMap<Integer, Carts> cart;

    public CartMB() {
        cart = new HashMap<>();
    }

    public HashMap<Integer, Carts> getCart() {
        HttpSession session = SessionManaged.getSession();
        if (session.getAttribute("CART") != null) {
            cart = (HashMap<Integer, Carts>) session.getAttribute("CART");
        } else {
            cart = new HashMap<>();
        }
        return cart;
    }

    public void setCart(HashMap<Integer, Carts> cart) {
        HttpSession session = SessionManaged.getSession();
        session.setAttribute("CART", cart);
    }

    public String addCart(Services product) {
        cart = getCart();
        if (cart.containsKey(product.getServiceID())) {
            cart.get(product.getServiceID()).quantity++;
        } else {
            cart.put(product.getServiceID(), new Carts(product.getServiceName(), product.getImage(), product.getServiceID(), product.getServicePrice()));
        }
        setCart(cart);
        return "cart";
    }

    public String updateCart(Entry<Integer, Carts> entry) {
        cart = getCart();
        if (entry.getValue().quantity <= 0) {
            cart.remove(entry.getKey());
        } else {
            cart.put(entry.getKey(), entry.getValue());
        }
        setCart(cart);
        return "cart";
    }

    public String goHome() {
        return "index";
    }
    
    public String removeCart(int id) {
        cart = getCart();
        if (cart.containsKey(id)) {
            cart.remove(id);
        }
        setCart(cart);
        return "cart";
    }

    public int getCount() {
        cart = getCart();
        return cart.size();
    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal(0);
        cart = getCart();
        if (cart.size() > 0) {
            for (Carts item : cart.values()) {
                total = total.add(new BigDecimal(item.quantity).multiply(item.getPrice()));
            }
        }
        return total;
    }

}
