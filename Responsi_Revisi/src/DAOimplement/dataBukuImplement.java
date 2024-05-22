/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOimplement;

import java.util.List;
import model.*;
        
/**
 *
 * @author Lab Informatika
 */
public interface dataBukuImplement {
    public void insert(dataBuku b);
    public void update(dataBuku b);
    public void delete(Integer id);
    public List<dataBuku> getAll();
}
