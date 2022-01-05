import {getType} from './funtion/getType.js'
import ramdom from './funtion/getRandom'

const boxEl = document.querySelector('.box');

boxEl.classList.remove('active');
let isContains = boxEl.classList.contains('active');
console.log(isContains);
