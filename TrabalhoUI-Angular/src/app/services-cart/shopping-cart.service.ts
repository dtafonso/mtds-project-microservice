import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {catchError} from 'rxjs/operators';
import {Utils} from '../util/utils';
import {CartToOrder} from '../models/cart-to-order';

@Injectable({
  providedIn: 'root'
})

export class ShoppingCartService {

  utils: Utils = new Utils();

  urlGetCart = 'http://loja-microservicos.info:30073/lastcart';
  urlSendToOrder = 'http://loja-microservicos.info:30076/cart-rabbitmq/producer';

  constructor(private httpClient: HttpClient) {
  }

  // Headers
  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  // get cart
  getCarts() {
    return this.httpClient.get(this.urlGetCart);
  }

  // send amount to backend and there, to order service
  sendToOrderBackend(cartToOrder: CartToOrder) {
    console.log(cartToOrder);
    return this.httpClient.post<CartToOrder>(this.urlSendToOrder, cartToOrder, this.httpOptions);
  }

}
