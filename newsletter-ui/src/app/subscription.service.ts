import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Subscription } from './subscription';

@Injectable({
  providedIn: 'root'
})
export class SubscriptionService {

  private baseUrl = "http://newsletter-subscription.newsletter.svc/api/v1/subscriptions";

  constructor(private http: HttpClient) { }

  getSubscription(): Observable<Subscription[]>{
    return this.http.get<Subscription[]>(`${this.baseUrl}`);
  }
}
