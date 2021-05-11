import State from '../src/State';
import Utils from '../src/Utils';

describe('State class', () => {

    describe('when get current state', () => {

        it('should check if a elem have a state', () => {
            const param = new State('opened');

            assert.isTrue(Utils.haveState(param));
        });

        it('should return an error if state is not defined', () => {
            const param = new State();

            assert.throws(() => { param.getCurrentState() }, Error);
        });

        it('should return a state', () => {
            const param = new State('enabled');

            assert.equal(param.getCurrentState(), 'enabled');
        });

    });

    describe('when setCurrentState', () => {
        it('should set state with the received value', () => {
            const param = new State();

            param.setCurrentState('enabled');

            assert.equal(param.getCurrentState(), 'enabled');
        });

        it('should set a state', () => {
            const param = new State('enabled');

            assert.doesNotThrow(() => { param.setCurrentState('closed') });
        });

    });

});