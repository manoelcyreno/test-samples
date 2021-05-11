describe("Test Suite", function() {

  describe('in Hello World' , function () {
    var Helloworld = require('../../src/Helloworld');

    describe('message function', () => {

      it('should return a message containing hello world!', function () {
        var helloworld = new Helloworld();

        expect(helloworld.message()).toEqual('Hello world!');
      });
    });
  });

  describe('in Person', function() {
    var Person = require('../../src/Person');

    describe('helloSomeone function', function() {

      it('should verify if sayHello() function was called by other method', function(){
        var fakePerson = new Person();
        spyOn(fakePerson, 'sayHello');
        fakePerson.helloSomeone('world');

        expect(fakePerson.sayHello).toHaveBeenCalled();
      });

      it('should verify if helloSomeone() function was called by presence of a parameter', function (){
        var fakePerson = new Person();
        spyOn(fakePerson, 'helloSomeone');
        fakePerson.helloSomeone('world');

        expect(fakePerson.helloSomeone).toHaveBeenCalledWith('world');
      });

      it('should verify if helloSomeone() function was called by not presence of parameter', function () {
        var fakePerson = new Person();
        spyOn(fakePerson, 'helloSomeone');
        fakePerson.helloSomeone('world');

        expect(fakePerson.helloSomeone).not.toHaveBeenCalledWith('foo');
      });

    });

  });

});
