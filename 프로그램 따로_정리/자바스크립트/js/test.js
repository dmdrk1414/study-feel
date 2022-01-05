var user = {
    name : 'park_seung_chan',
    age : 27,
    getName: function (){
        return this.name;
    }
}

console.log(user.getName());

const test = user.getName();
console.log(test);
