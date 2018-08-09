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
  expenseValueFrom: '',
  expenseValueTo: '',
  expenseDateFrom: '',
  expenseDateTo: ''
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
      expenseValueFrom: '',
      expenseValueTo: '',
      expenseDateFrom: '',
      expenseDateTo: ''
    };

  }

  getPesquisa() {
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
    };

    req.send();
  }

  composeUrl(): string {
    let url = 'http://localhost:8080/alepe/pesquisa';
    let paradd = false;
    if (this.detailParameters.parlamentar_fantasia != '') {
      url += '?parlamentar_fantasia=' + this.detailParameters.parlamentar_fantasia;
      paradd = true;
    }
    if (this.detailParameters.parlamentar_partido != '') {
      if (paradd) {
        url += '&parlamentar_partido=' + this.detailParameters.parlamentar_partido;
      } else {
        url += '?parlamentar_partido=' + this.detailParameters.parlamentar_partido;
        paradd = true;
      }
    }
    if (this.detailParameters.fornecedor_id != '') {
      if (paradd) {
        url += '&fornecedor_id=' + this.detailParameters.fornecedor_id;
      } else {
        url += '?fornecedor_id=' + this.detailParameters.fornecedor_id;
        paradd = true;
      }
    }
    if (this.detailParameters.fornecedor_nome != '') {
      if (paradd) {
        url += '&fornecedor_nome=' + this.detailParameters.fornecedor_nome;
      } else {
        url += '?fornecedor_nome=' + this.detailParameters.fornecedor_nome;
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
      expenseValueFrom: '',
      expenseValueTo: '',
      expenseDateFrom: '',
      expenseDateTo: ''
    }
    this.detailParameters.limit = 9999;
  }
}
