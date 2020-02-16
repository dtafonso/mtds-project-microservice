import {ProductCart} from '../models/product-cart.model';

export interface Cart {
  id: number;
  productsList: ProductCart[];
  date: string;

}
