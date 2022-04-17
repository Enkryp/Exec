const fs = require('fs')
const lrs = require("lrs");

var da,db,dc;
fs.readFile('./a.txt', 'utf8' , (err, data) => {
  if (err) {
    console.error(err);
    return;
  }
  da=data;
  fs.readFile('./b.txt', 'utf8' , (err, data) => {
    if (err) {
      console.error(err);
      return;
    }
    db=data;
    fs.readFile('c.txt', 'utf8' , (err, data) => {
      if (err) {
        console.error(err);
        return;
      }
      dc=data;
      da = da.substring(1, da.length-1);
      var publicKeyList = da.split(",");
      console.log(lrs.verify(publicKeyList, db, dc));
    })
  })
})




