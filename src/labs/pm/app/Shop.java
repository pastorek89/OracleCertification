/*
 * Copyright (C) 2021 pastor
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package labs.pm.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Locale;
import labs.pm.data.Drink;
import labs.pm.data.Food;
import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.Rating;

/**
 *
 * @author pastor
 */
public class Shop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProductManager pm = new ProductManager("en-GB");
        pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
//        pm.printProductReport(101);
        
        pm.reviewProduct(101, Rating.FOUR_STAR, "A nice cup of tee");
        pm.reviewProduct(101, Rating.TWO_STAR, "Bleee");
        pm.reviewProduct(101, Rating.THREE_STAR, "Just add some lemon");
        pm.reviewProduct(101, Rating.FOUR_STAR, "Really good");
        pm.reviewProduct(101, Rating.FIVE_STAR, "Great!");        
//        pm.printProductReport(101);
        
//        pm.changeLocale("zh-CN");
        
        pm.createProduct(102, "Coffee", BigDecimal.valueOf(2.99), Rating.FOUR_STAR);
        pm.reviewProduct(102, Rating.FIVE_STAR, "A nice cup of Coffe");
        pm.reviewProduct(102, Rating.FIVE_STAR, "SUPER");
        pm.reviewProduct(102, Rating.FIVE_STAR, "+++");
//        pm.printProductReport(p2);
        
        pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
        pm.reviewProduct(103, Rating.ONE_STAR, "A nice for a trash");
        pm.reviewProduct(103, Rating.TWO_STAR, "Bleee");
        pm.reviewProduct(103, Rating.TWO_STAR, "Misia did it");
        pm.reviewProduct(103, Rating.FOUR_STAR, "Really good");
        pm.reviewProduct(103, Rating.ONE_STAR, "Bad!");  
        
        Comparator<Product> ratingSorter = (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();
        Comparator<Product> priceSorter = (p1, p2) -> p2.getPrice().compareTo(p1.getPrice());
        pm.printProducts(ratingSorter);
        pm.printProducts(priceSorter);
        pm.printProducts(ratingSorter.thenComparing(priceSorter));
        pm.printProducts(ratingSorter.thenComparing(priceSorter).reversed());
//        Product p4 = pm.createProduct(105, "Cookie", BigDecimal.valueOf(3.99), Rating.TWO_STAR, LocalDate.now());
//        Product p5 = p3.applyRating(Rating.THREE_STAR);
//        Product p6 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR);
//        Product p7 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
//        Product p8 = p4.applyRating(Rating.FIVE_STAR);
//        Product p9 = p1.applyRating(Rating.TWO_STAR);
//
//        System.out.println(p1.getBestBefore());
//        System.out.println(p3.getBestBefore());
//
//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(p3);
//        System.out.println(p4);
//        System.out.println(p5);
//        System.out.println(p6);
//        System.out.println(p7);
//        System.out.println(p8);
//        System.out.println(p9);
    }

}
