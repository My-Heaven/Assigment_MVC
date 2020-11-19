/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datvt.tblitem;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Tan DaT
 */
public class CartObject implements Serializable {

    private Map<String, tblItemDTO> Item = null;

    public Map<String, tblItemDTO> getItem() {
        return Item;
    }

    public void add(tblItemDTO dto) {
        if (this.Item == null) {
            this.Item = new HashMap<String,tblItemDTO>();
        }
        if (this.Item.containsKey(dto.getId())) {
            int quantity = this.Item.get(dto.getId()).getQuantity();
            dto.setQuantity(quantity+1);
        }
        this.Item.put(dto.getId(), dto);
    }

    public void removeItemFromCart(String id) {
        //1. Check items exited
        if (this.Item == null) {
            return;
        }
        //2. Check item existed
        
        if (this.Item.containsKey(id)) {
            this.Item.remove(id);
        }

        if (this.Item.isEmpty()) {
            this.Item = null;
        }
    }
}
