'use strict';

class State {

    constructor (state) {
        if (this.isState(state)) {
            this.state = state;
        }
    }

    isState(value) {
        if (['enabled', 'disabled', 'closed', 'opened'].includes(value)) {
            return true;
        }
        return false;
    }

    getCurrentState() {
        if(this.state) {
            return this.state;
        }

        throw new Error('State is not defined');
    }

    setCurrentState(newState) {
        this.isState(newState);
        this.state = newState;
    }

}

export default State;