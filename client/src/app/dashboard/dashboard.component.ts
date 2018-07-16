import { SummaryExpensesYearService } from './../summary-expenses-year.service';
import { SummarySupplierService } from './../summary-supplier.service';
import { SummaryMemberService } from './../summary-member.service';
import { Component, OnInit, ViewChild, TemplateRef} from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  @ViewChild('myTable') table: any;

  rowsDep = [];
  columnsDep = [
    {
      prop: 'name',
      name: 'name',

    },
    {
      prop:'media',
      name:'media'
    },
    {
      prop : 'total',
      name: 'total'
    },
  ]


  rowsForn = [];
  columnsForn = [
    {
        prop:'nomeFornecedor',
        name:'nomeFornecedor'
    },
    {
        prop: 'totalRecebido',
        name:'totalRecebido'
    },
    {
        prop:'qtdDept',
        name:'qtdDept'
    }
  ]


  rowsDespesa = [];
  columnsDespesa=[
    {
      prop:'tipo',
      name:'tipo'
    },
    {
      prop:'y2015',
      name:'y2015'
    },
    {
      prop:'y2016',
      name:'y2016'
    },
    {
      prop:'y2017',
      name:'y2017'
    },
    {
      prop:'totalDespesas',
      name:'totalDespesas'
    }
  ]

  summaryMemberRows = [];
  summarySupplierRows = [];
  summaryExpesesYearRows = [];
  constructor(
    config: NgbCarouselConfig,
    private _http: HttpClient,
    private summaryMemberService: SummaryMemberService,
    private summarySupplierService: SummarySupplierService,
    private summaryExpensesYearService: SummaryExpensesYearService

  ) {

    this.fetchDeputados((data) => {
      this.rowsDep = data;
    });

    this.fetchFornecedores((data) => {
      this.rowsForn = data;
    });

    this.fetchDespesas((data) => {
      this.rowsDespesa = data;
    });

    // customize default values of carousels used by this component tree
    config.interval = 10000;
    config.wrap = false;
    config.keyboard = false; }

  ngOnInit() {
    this.loadMemberSummary();
    this.loadSupplierSummary();
    this.loadYearExpensesSummary();

    this.columnsDep = [
      {
        prop: 'name',
        name: 'name',

      },
      {
        prop:'media',
        name: 'media'
      },
      {
        prop : 'total',
        name: 'total'
      },
    ];
    this.columnsForn = [
      {
        prop:'nomeFornecedor',
        name:'nomeFornecedor'
      },
      {
        prop: 'totalRecebido',
        name:'totalRecebido'
      },
      {
        prop:'qtdDept',
        name:'qtdDept'
      }
    ];
    this.columnsDespesa=[
      {
        prop:'tipo',
        name:'tipo'
      },
      {
        prop:'y2015',
        name:'y2015'
      },
      {
        prop:'y2016',
        name:'y2016'
      },
      {
        prop:'y2017',
        name:'y2017'
      },
      {
        prop:'totalDespesas',
        name:'totalDespesas'
      }
    ]

  }

  loadMemberSummary(): void {
    this.summaryMemberService.getSummaryMember().subscribe(res => this.summaryMemberRows = res.data);
  }

  loadSupplierSummary(): void {
    this.summarySupplierService.getSummarySupplier().subscribe(res => this.summarySupplierRows = res.data);
  }

  loadYearExpensesSummary(): void {
    this.summaryExpensesYearService.getSummaryExpensesYear().subscribe(res => this.summaryExpesesYearRows = res.data);
  }

  fetchDeputados(cb) {
    const req = new XMLHttpRequest();
    req.open('GET', `http://localhost:3000/deputados`);

    req.onload = () => {
      cb(JSON.parse(req.response));
    };

    req.send();
  }

  fetchFornecedores(cb) {
    const req = new XMLHttpRequest();
    req.open('GET', `http://localhost:4000/fornecedores`);

    req.onload = () => {
      cb(JSON.parse(req.response));
    };

    req.send();
  }

  fetchDespesas(cb){
    const req = new XMLHttpRequest();
    req.open('GET','http://localhost:3200/despesas');

    req.onload = () => {
      cb(JSON.parse(req.response));
    };

    req.send();
  }
}
