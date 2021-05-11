import State from '../src/State';
import Utils from '../src/Utils';

describe('State class', () => {

    describe('when get current state', () => {

        it('should check if a elem have a state', () => {
            const param = new State('opened');

            expect(Utils.haveState(param)).toBeTruthy();
        });

        it('should return disabeld if state is not defined', () => {
            const param = new State();

            expect(param.getCurrentState()).toEqual('disabled');
        });

        it('should return a state', () => {
            const param = new State('enabled');

            param.setCurrentState('opened');

            expect(param.getCurrentState()).toEqual('opened');
        });

    });

    describe('when setCurrentState', () => {
        it('should set state with the received value', () => {
            const param = new State();

            param.setCurrentState('enabled');

            expect(param.getCurrentState()).toEqual('enabled');
        });

        it('should set a state', () => {
            const param = new State('enabled');

            expect(param.setCurrentState('closed')).toBeTruthy();
        });

        it('should throw an error if given argument is invalid', () => {
            const param = new State();

            expect(() => { param.setCurrentState('') }).toThrow(TypeError);
        });
    });

});