import { Component, OnInit } from '@angular/core';
import {Distrito} from '../model/distrito';
import { RappieduService } from '../rappiedu.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-distrito-create',
  templateUrl: './distrito-create.component.html',
  styleUrls: ['./distrito-create.component.css']
})
export class DistritoCreateComponent implements OnInit {

  distrito: Distrito = new Distrito();
  constructor(private rappieduService: RappieduService,
    private router: Router) { }

  ngOnInit(): void {
  }

  save() {
    console.log(this.distrito);
    this.rappieduService.createDistrito(this.distrito).subscribe(
      data=> this.router.navigate(['RappiEDU/Estudiante/dis-list']) //luego ir a list para ver si se ha creado el producto
    )
  }

}
