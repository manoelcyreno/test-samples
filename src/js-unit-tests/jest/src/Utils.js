'use strict';

const Utils = {

    haveState(obj) {
        if (typeof obj == 'object' && obj.hasOwnProperty('state')){
            return true;
        }
        return false;
    },

    getChuckMessage() {
        return fetch('http://api.icndb.com/jokes/random?firstName=Diego&amp;lastName=Nascimento')
            .then(data => data.json())
            .then(response => {
                return response;
            }).catch(error => {
                throw new Error(`Something wrong: ${error}`);
            });
    }



};


export default Utils;