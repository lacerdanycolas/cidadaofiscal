
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
        prop: 'nome',
        name: 'nome'
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

  setPage(pageInfo){
    // metodo que me indica qual pagina o usuario está
    var pageNumber = pageInfo.offset;
    //this.fetchVoluntarios(data, pageNumber);
  }

  fetchVoluntarios(cb) {
    const req = new XMLHttpRequest();
    req.open('GET', `http://localhost:8080/voluntario/all`);

    req.onload = () => {
      debugger;
      cb(JSON.parse(req.response));
    };

    req.send();
  }
}
