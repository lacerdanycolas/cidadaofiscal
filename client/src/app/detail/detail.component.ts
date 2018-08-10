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
    { prop: 'memberPoliticalName', name: 'Deputado' },
    { prop: 'memberParty', name: 'Partido' },
    { prop: 'supplierName', name: 'Fornecedor'},
    { prop: 'expenseType', name: 'Tipo de Despesa'},
    { prop: 'expenseValue', name: 'Valor'},
    { prop: 'expenseCanceled', name: 'Nota Cancelada'},
    { prop: 'expenseDate', name: 'Data'}
  ];

  detailParameters = new DetailParameters();

  constructor(private detailService: DetailService) {
    this.detailParameters.limit = 9999;
  }

  ngOnInit() {
    this.detailParameters.memberPoliticalName = '';
    this.detailParameters.memberParty = '';
    this.detailParameters.supplierName = '';

  }

  getDetails(): void {

    this.pesquisaDeputados((data) => {
      console.log(data);
      this.detailRows = data;
    });
  }

  pesquisaDeputados(cb) {
    const req = new XMLHttpRequest();
    var reqString = 'http://localhost:8080/alepe/pesquisa?name=' + this.detailParameters.memberPoliticalName +
    '&partido=' + this.detailParameters.memberParty + '&fornecedor=' +this.detailParameters.supplierName;

    if (this.detailParameters.expenseValueFrom != null && this.detailParameters.expenseValueTo != null) {
      reqString += '&valorMin=' + this.detailParameters.expenseValueFrom;
      reqString += '&valorMax=' + this.detailParameters.expenseValueTo;
    } else {
      reqString += '&valorMin=&valorMax='
    }

    if (this.detailParameters.expenseDateFrom && this.detailParameters.expenseDateTo) {
      reqString += '&dataMin=' + this.detailParameters.expenseDateFrom;
      reqString += '&dataMax=' + this.detailParameters.expenseDateTo;
    } else {
      reqString += '&dataMin=&dataMax='
    }

    req.open('GET', reqString);

    req.onload = () => {
      cb(JSON.parse(req.response));
    };

    req.send();
  }

  resetParameters() {
    this.detailParameters = new DetailParameters();
    this.detailParameters.limit = 9999;
  }
}
