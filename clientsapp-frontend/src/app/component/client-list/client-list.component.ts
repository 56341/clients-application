import { Component, OnInit } from '@angular/core';
import {ClientService} from "../../service/client/client.service";
import {MinimalClient} from "../../model/minimal-client";

@Component({
  selector: 'app-clients',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {

  clients: MinimalClient[] = [];

  constructor(private clientService: ClientService) { }

  ngOnInit(): void {
    this.getClients();
  }

  getClients = (): void => {
    this.clientService.getClients()
      .subscribe((clients: MinimalClient[]) => {
        this.clients = clients;
    })
  }
}
