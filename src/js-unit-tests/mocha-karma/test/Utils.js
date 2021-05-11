import Utils from '../src/Utils';
import State from '../src/State';

describe('haveState function', () => {
    it('should return false if receive an type different from object', () => {
        let param = 2;

        assert.isFalse(Utils.haveState(param));
    });

    it('should return false if received argument doesnt have state', () => {
        let param = {};

        assert.isFalse(Utils.haveState(param));
    });

    it('should return true if received argument have state', () => {
        let param = new State('enabled');

        assert.isTrue(Utils.haveState(param));
    });
});

describe('getChuckMessage function', () => {
    it('should return an promise containing a joke', (done) => {
        const joke = Utils.getChuckMessage();

        joke.then(res => {
            assert.equal(res.type, 'sucess');
        }).finally(done);
    });
});

