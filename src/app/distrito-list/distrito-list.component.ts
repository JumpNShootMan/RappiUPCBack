import { Component, OnInit } from '@angular/core';
import {Distrito} from '../model/distrito';
import { Observable } from 'rxjs';
import { RappieduService } from '../rappiedu.service';

@Component({
  selector: 'app-distrito-list',
  templateUrl: './distrito-list.component.html',
  styleUrls: ['./distrito-list.component.css']
})
export class DistritoListComponent implements OnInit {

  distritos : Observable<Distrito>
  constructor(private rappieduService: RappieduService) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    console.log("Reload!!!")
    this.rappieduService.getDistritoList().subscribe(distritos => this.distritos = distritos)
  }

}
