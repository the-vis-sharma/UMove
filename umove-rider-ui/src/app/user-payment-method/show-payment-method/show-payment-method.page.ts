import { Component, OnInit } from '@angular/core';

import {NavigationExtras, Router} from '@angular/router';
import {HttpClient, HttpClientModule} from '@angular/common/http';

import {json} from '@angular-devkit/core';
import {HTTP} from '@ionic-native/http/ngx';
import {UserPaymentMethod} from '../../model/user-payment-method/user-payment-method';
import {UserPaymentMethodService} from '../../services/user-payment-method/user-payment-method.service';

@Component({
  selector: 'app-show-payment-method',
  templateUrl: './show-payment-method.page.html',
  styleUrls: ['./show-payment-method.page.scss'],
})
// tslint:disable-next-line:component-class-suffix
export class ShowPaymentMethodPage implements OnInit {
  public payment: UserPaymentMethod;

  constructor(private userPaymentMethodService: UserPaymentMethodService, private router: Router, private http: HTTP) { }

   ngOnInit() {
    this.userPaymentMethodService.getAllPaymentMethod('5da1b2ba0e8e3d0001e33275')
        .then(data => {
          console.log('filtered data: ', data);
          console.log('Response: ', data.data);
          this.payment = JSON.parse(data.data).data;
        });
  }
    goToHome() {}
    goAnotherPage() {
        this.router.navigateByUrl('/add-payment-method');
    }
    onSelect(data) {
        const navigationExtras: NavigationExtras = {
            queryParams: {
                special: data
            }
        };
        this.router.navigateByUrl('/poc-payment', navigationExtras);
    }
  onDelete(pid: any) {
     this.userPaymentMethodService.deletePaymentMethod('5da1b2ba0e8e3d0001e33275', pid)
         .then(
             resp => console.log('deleted'),
             error => console.log(error)
         );
}
}
