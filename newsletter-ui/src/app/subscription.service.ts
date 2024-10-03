import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Subscription } from './subscription';

@Injectable({
  providedIn: 'root'
})
export class SubscriptionService {

  private baseUrl = "https://newsletter-subscription.apps.corelab.core-software.ch";

  constructor(private http: HttpClient) { }

  getSubscription(): Observable<Subscription[]>{
    return this.http.get<Subscription[]>(`${this.baseUrl}`);
  }
}
