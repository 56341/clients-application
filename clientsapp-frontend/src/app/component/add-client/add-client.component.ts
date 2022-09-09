import { Component, OnInit } from '@angular/core';
import {CountryService} from "../../service/country/country.service";
import { NewClient} from "../../model/new-client";
import {ClientService} from "../../service/client/client.service";

@Component({
  selector: 'app-add-client',
  templateUrl: './add-client.component.html',
  styleUrls: ['./add-client.component.css']
})
export class AddClientComponent implements OnInit {

  countries: string[] = [];

  clientModel = new NewClient('', '', '', '', '', '');

  constructor(private countryService: CountryService, private clientService: ClientService) { }

  ngOnInit(): void {
    this.getCountries();
  }

  getCountries = (): void => {
    this.countryService.getCountries()
      .subscribe((countries: string[]) => {
        if (!countries.length) {
          console.error('No countries available!')
        } else {
          this.countries = countries;
        }
    })
  }

  onSubmit() {
    this.clientService.createClient(this.clientModel)
      .subscribe(
        result => {
          window.alert('New client created successfully!');
          },
          error => {
          window.alert('Failed to create a new client!');
        });
  }

}
