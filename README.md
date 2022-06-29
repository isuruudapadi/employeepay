# employeepay -Spring Boot Backend API
Spring API Technical Assesment

Assumption :JSOn file save on ="..\\employeepay\\data.json "

json file 

[{
	"min": 0,
	"max": 18200,
	"defaultTax": 0,
	"taxRate": 0
}, {
	"min": 18201,
	"max": 37000,
	"defaultTax": 0,
	"taxRate": 0.19
}, {
	"min": 37001,
	"max": 87000,
	"defaultTax": 3572,
	"taxRate": 0.325
}, {
	"min": 87001,
	"max": 180000,
	"defaultTax": 19822,
	"taxRate": 0.37
}, {
	"min": 180001,
	"max": 1000000,
	"defaultTax": 54235,
	"taxRate": 0.45
}]

*****************
localhost:8080/api/payCalculation

INPUT
******************
POST /api/payCalculation HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 258

[{
  	"firstName":"Chen",
   	"lastName":"Rudd",
   	"annualSalary":60475757,
  	"paymentMonth":4,
  	"superRate":0.09
  },{
  	"firstName":"David",
   	"lastName":"Rudd",
   	"annualSalary":600740,
  	"paymentMonth":6,
  	"superRate":0.09
  }]
  *************
  Output
  ****************
  {
    "employee:{firstName:Chen,lastName:Rudd,annualSalary:60475757,paymentMonth:4,superRate:0.09},": {
        "fromDate": "01 MAY",
        "toDate": "31 MAY",
        "grossIncome": 5039647.0,
        "incomeTax": 419971.0,
        "superannuation": 453569.0,
        "netIncome": 4619676.0
    },
    "employee:{firstName:David,lastName:Rudd,annualSalary:600740.0,paymentMonth:6,superRate:0.09},": {
        "fromDate": "01 JULY",
        "toDate": "31 JULY",
        "grossIncome": 50062.0,
        "incomeTax": 4172.0,
        "superannuation": 4506.0,
        "netIncome": 45890.0
    }
}
