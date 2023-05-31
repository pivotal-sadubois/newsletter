import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatLegacyButtonModule as MatButtonModule } from "@angular/material/legacy-button";
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home.component';
import { TopBarComponent } from "./top-bar/top-bar.component";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatLegacyTableModule as MatTableModule} from "@angular/material/legacy-table";
import {CustomerProfileModule} from "./customer-profile/customer-profile.module";

@NgModule({
  declarations: [
    HomeComponent,
    TopBarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    CustomerProfileModule,
    MatToolbarModule,
    MatButtonModule,
  ],
  providers: [],
  bootstrap: [HomeComponent]
})
export class AppModule {
}
