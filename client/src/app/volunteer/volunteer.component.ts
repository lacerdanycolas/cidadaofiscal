
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
  pageNumber = 0;
  totalItens;
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
    }, this.pageNumber);
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

  /*setPage(pageInfo){
    // metodo que me indica qual pagina o usuario está
    this.pageNumber = pageInfo.offset;
    this.totalItens = pageInfo.totalElements;
    this.fetchVoluntarios((data) => {
      this.rowsVol = data.content;
    });
    //this.fetchVoluntarios(data, pageNumber);
  }*/

  getTotal(cb) {
    const req = new XMLHttpRequest();
    req.open('GET', `http://localhost:8080/voluntario/total`);

    req.onload = () => {
      cb(JSON.parse(req.response));
    };

    req.send();
  }

  fetchVoluntarios(cb, pageNumber) {
    const req = new XMLHttpRequest();
    //req.open('GET', `http://localhost:8080/voluntario?page=${pageNumber}&size=5`);
    req.open('GET', `http://localhost:8080/voluntario/all`);

    req.onload = () => {
      cb(JSON.parse(req.response));
    };

    req.send();
  }
}
