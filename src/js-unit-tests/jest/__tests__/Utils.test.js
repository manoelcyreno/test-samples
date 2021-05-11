import Utils from '../src/Utils';
import State from '../src/State';
import "whatwg-fetch";

describe('haveState function', () => {
    it('should return false if receive an type different from object', () => {
        let param = 2;

        expect(Utils.haveState(param)).toBeFalsy();
    });

    it('should return false if received argument doesnt have state', () => {
        let param = {};

        expect(Utils.haveState(param)).toBeFalsy();
    });

    it('should return true if received argument have state', () => {
        let param = new State('enabled');

        expect(Utils.haveState(param)).toBeTruthy();
    });
});

describe('getChuckMessage function', () => {
    it('should return an promise containing a joke', async () => {
        const joke = await Utils.getChuckMessage();

        expect(joke.type).toEqual('success');
    });

    it('should throw an error if promise was rejected', async () => {
        try {
            await Utils.getChuckMessage();
        } catch (e) {
            expect(e.type).toEqual(/error/);
        }
    });
});

