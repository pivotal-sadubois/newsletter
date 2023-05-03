import { Component, OnInit } from '@angular/core';
import {SubscriptionService} from '../subscription.service'
import { Subscription } from '../subscription';

@Component({
  selector: 'app-user',
  templateUrl: './subscription.component.html',
  styleUrls: ['./subscription.component.css']
})
export class SubscriptionComponent implements OnInit {

  subscriptions: Subscription[] = [];
  constructor(private subscriptionService: SubscriptionService) { }

  ngOnInit(): void {
    this.subscriptionService.getSubscription().subscribe((data: Subscription[]) => {
      console.log(data);
      this.subscriptions = data;
    });
  }
}