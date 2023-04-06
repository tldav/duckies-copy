let originalCart = [
  {
    "id": "1",
    "items": [
      {
        "product": {
          "id": "1",
          "name": "Golden Duck",
          "price": 150,
          "stock": 2
        },
        "quantity": 1
      }
    ],
    "total": 150
  },
  {
    "id": "2",
    "items": [
      {
        "product": {
          "id": "3",
          "name": "",
          "price": 300,
          "stock": 5
        },
        "quantity": 2
      },
      {
        "product": {
          "id": "2",
          "name": "1 Duck",
          "price": 200,
          "stock": 4
        },
        "quantity": 4
      },
      {
        "product": {
          "id": "5",
          "name": "RUBBER DUCK",
          "price": 100,
          "stock": 3
        },
        "quantity": 0
      }
    ],
    "total": 5888
  },
  {
    "id": "3",
    "items": [],
    "total": 0
  },
  {
    "id": "4",
    "items": [],
    "total": 0
  },
  {
    "id": "5",
    "items": [],
    "total": 0
  },
  {
    "id": "6",
    "items": [],
    "total": 0
  },
  {
    "id": "7",
    "items": [],
    "total": 0
  },
  {
    "id": "8",
    "items": [],
    "total": 0
  },
  {
    "id": "9",
    "items": [],
    "total": 0
  },
  {
    "id": "10",
    "items": [],
    "total": 0
  }
]
;

const fs = require("fs");
const path = "../data/carts.json";

fs.writeFileSync(path, JSON.stringify(originalCart), (err) => {
  if (err) {
    throw "failed to write to json";
  }
});
