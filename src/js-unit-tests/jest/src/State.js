'use strict';

class State {

    constructor (state) {
        if(this.isState(state)) {
            this.state = state;
        } else {
            this.state = 'disabled';
        }
    }

    isState(value) {
        if (['enabled', 'disabled', 'closed', 'opened'].includes(value)) {
            return true;
        }
        return false;
    }

    getCurrentState() {
        return this.state;
    }

    setCurrentState(newState) {
        if(this.isState(newState)){
            this.state = newState;
            return true;
        }

        throw new TypeError(`${newState} is not a valid state!`);
    }

}

export default State;