// в express будет лежать библиотека express
const express = require('express');
// создаем экземпляр сервера
const app = express();
// подключаем к нему папку public
app.use(express.static('public'));
// запускаем сервер на порту 80
app.listen(80);
console.log("Server started at 80");