
const fs = require('fs')

var da,db,dc;
fs.readFile('./a.txt', 'utf8' , (err, data) => {
  if (err) {
    console.error(err)
    return
  }
  da=data
})

fs.readFile('./b.txt', 'utf8' , (err, data) => {
    if (err) {
      console.error(err)
      return
    }
    db=data
  })

  fs.readFile('./c.txt', 'utf8' , (err, data) => {
    if (err) {
      console.error(err)
      return
    }
    dc=data
  })

var lrs = require("lrs");
var publicKeyList=JSON.parse(da);
console.log(lrs.verify(publicKeyList, db, dc));
