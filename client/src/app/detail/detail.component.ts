import { DetailService } from './../detail.service';
import { Component, OnInit } from '@angular/core';
import { DetailParameters } from './../detail-parameters';




@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  detailRows = [];
  detailCols = [
    { prop: 'parlamentar_fantasia', name: 'parlamentar_fantasia' },
    { prop: 'parlamentar_partido', name: 'parlamentar_partido' },
    { prop: 'despesa_tipo', name: 'despesa_tipo'},
    { prop: 'fornecedor_nome', name: 'fornecedor_nome'},
    { prop: 'despesa_valor', name: 'despesa_valor'},
    { prop: 'despesa_data', name: 'despesa_data'}
  ];

  detailParameters = {
    limit: 0,
  parlamentar_fantasia: '',
  parlamentar_partido: '',
  fornecedor_id: '',
  fornecedor_nome: '',
  despesa_valorDe: '',
  despesa_valorAte: '',
  despesa_dataDe: '',
  despesa_dataAte: ''
  };

  url;


  constructor(private detailService: DetailService) {
    this.detailParameters.limit = 9999;
  }

  ngOnInit() {
   this.detailParameters = {
      limit: 9999,
      parlamentar_fantasia: '',
      parlamentar_partido: '',
      fornecedor_id: '',
      fornecedor_nome: '',
      despesa_valorDe: '',
      despesa_valorAte: '',
      despesa_dataDe: '',
      despesa_dataAte: ''
    };
  }

  getPesquisa() {
    document.getElementById("loadingDiv").style["display"] =  "block";
    this.fetchPesquisa((data) => {
      this.detailRows = data;
    });
  }

  fetchPesquisa(cb) {
    this.url = this.composeUrl();
    const req = new XMLHttpRequest();
    req.open('GET', this.url);
    req.onload = () => {
      cb(JSON.parse(req.response));
      document.getElementById("loadingDiv").style["display"] =  "none";
    };

    req.send();
  }

  composeUrl(): string {
    debugger;
    let url = 'http://localhost:8080/alepe/pesquisa';
    let paradd = false;
    if (this.detailParameters.parlamentar_fantasia != '' && this.detailParameters.parlamentar_fantasia != null
        && this.detailParameters.parlamentar_fantasia != undefined) {
      url += '?parlamentar_fantasia=' + this.detailParameters.parlamentar_fantasia;
      paradd = true;
    }
    if (this.detailParameters.parlamentar_partido != '' && this.detailParameters.parlamentar_partido != null 
        && this.detailParameters.parlamentar_partido != undefined) {
      if (paradd) {
        url += '&parlamentar_partido=' + this.detailParameters.parlamentar_partido;
      } else {
        url += '?parlamentar_partido=' + this.detailParameters.parlamentar_partido;
        paradd = true;
      }
    }
    if (this.detailParameters.fornecedor_id != '' && this.detailParameters.fornecedor_id != null 
        && this.detailParameters.fornecedor_id != undefined ) {
      if (paradd) {
        url += '&fornecedor_id=' + this.detailParameters.fornecedor_id;
      } else {
        url += '?fornecedor_id=' + this.detailParameters.fornecedor_id;
        paradd = true;
      }
    }
    if (this.detailParameters.fornecedor_nome != '' && this.detailParameters.fornecedor_nome != null 
       && this.detailParameters.fornecedor_nome != undefined) {
      if (paradd) {
        url += '&fornecedor_nome=' + this.detailParameters.fornecedor_nome;
      } else {
        url += '?fornecedor_nome=' + this.detailParameters.fornecedor_nome;
        paradd = true;
      }
    }
    if(this.detailParameters.despesa_dataDe != '' && this.detailParameters.despesa_dataDe != null 
      && this.detailParameters.despesa_dataDe != undefined){
      if(paradd){
        url += '&despesa_dataDe=' + this.detailParameters.despesa_dataDe;
      } else{
        url += '?despesa_dataDe=' + this.detailParameters.despesa_dataDe;
        paradd = true;
      }
    }
    if(this.detailParameters.despesa_dataAte != '' && this.detailParameters.despesa_dataAte != null
      && this.detailParameters.despesa_dataAte != undefined){
      if(paradd){
        url += '&despesa_dataAte=' + this.detailParameters.despesa_dataAte;
      } else{
        url += '?despesa_dataAte=' + this.detailParameters.despesa_dataAte;
        paradd = true;
      }
    }
    if(this.detailParameters.despesa_valorDe != '' && this.detailParameters.despesa_valorDe != null
      && this.detailParameters.despesa_valorDe != undefined){
      if(paradd){
        url += '&despesa_valorDe=' + this.detailParameters.despesa_valorDe;
      } else{
        url += '?despesa_valorDe=' + this.detailParameters.despesa_valorDe;
        paradd = true;
      }
    }
    if(this.detailParameters.despesa_valorAte != '' && this.detailParameters.despesa_valorAte != null
      && this.detailParameters.despesa_valorAte != undefined){
      if(paradd){
        url += '&despesa_valorAte=' + this.detailParameters.despesa_valorAte;
      } else{
        url += '?despesa_valorAte=' + this.detailParameters.despesa_valorAte;
        paradd = true;
      }
    }
    return url;
  }

  getDetails(): void {
    this.detailService.getDetails(this.detailParameters)
    .subscribe(detailResponse => this.detailRows = detailResponse.data);
  }

  resetParameters() {
    this.detailParameters = {
      limit: 0,
      parlamentar_fantasia: '',
      parlamentar_partido: '',
      fornecedor_id: '',
      fornecedor_nome: '',
      despesa_valorDe: '',
    despesa_valorAte: '',
    despesa_dataDe: '',
    despesa_dataAte: ''
    }
    this.detailParameters.limit = 9999;
  }
}
