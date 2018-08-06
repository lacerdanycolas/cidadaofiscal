
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-volunteer',
  templateUrl: './volunteer.component.html',
  styleUrls: ['./volunteer.component.css']
})
export class VolunteerComponent implements OnInit {
  
  @ViewChild('myTable') table: any;

  rowsVol = []
  columnsVol = [
    {
      prop: 'name',
      name: 'nomeVoluntario'
    },
    {
      prop: 'email',
      name: 'email',
    },
    {
      prop: 'telefone',
      name: 'telefone'
    },
    {
      prop: 'estado',
      name: 'estado'
    },
  ];

  constructor() {
    this.fetchVoluntarios((data) => {
      this.rowsVol = data;
    });
  }
  ngOnInit() {
    this.columnsVol = [
      {
        prop: 'nomeVoluntario',
        name: 'nomeVoluntario'
      },
      {
        prop: 'email',
        name: 'email',
      },
      {
        prop: 'telefone',
        name: 'telefone'
      },
      {
        prop: 'estado',
        name: 'estado'
      },
    ];
  }
  fetchVoluntarios(cb) {
    const req = new XMLHttpRequest();
    req.open('GET', `http://localhost:5000/voluntarios`);

    req.onload = () => {
      cb(JSON.parse(req.response));
    };

    req.send();
  }
}
