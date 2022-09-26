package springboot.my.projects.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.my.projects.database.DBManager.ItemDBManager;
import springboot.my.projects.database.constructors.Items;

import java.util.ArrayList;

@Controller
@RequestMapping("/item")
public class ItemController {

    @GetMapping(value = "/home")
    public String homePage(Model model) {
        ArrayList<Items> itemsList = ItemDBManager.getItems();
            model.addAttribute("goods", itemsList);
            return "homePage";
        }

        @GetMapping(value = "/additem")
        public String addItem (Model model){
            model.addAttribute("addItem", new Items());
            return "addItem";
        }

        @PostMapping(value = "/additem")
        public String addItem (@RequestParam(name = "itemName") String itemName,
                @RequestParam(name = "itemDescription") String itemDescription,
        @RequestParam(name = "itemPrice") double itemPrice){
            ItemDBManager.addItem(new Items(null, itemName, itemDescription, itemPrice));
            return "redirect:/item/home";
        }
    }



