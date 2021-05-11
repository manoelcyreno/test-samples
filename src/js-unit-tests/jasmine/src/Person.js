function Person() {
}

Person.prototype.helloSomeone = function (toGreet) {
    return this.sayHello() + ' ' + toGreet;
};

Person.prototype.sayHello = function () {
    return 'Hello';
};

module.exports = Person;
