window.app = new Vue({
    el: "#app",
    data: {
        userId: '',
        password: '',
        showAlert: false,
        errMsg: ''
    },
    methods: {
        jssubmit: function() {
            if ( this.userId == '' ) {
                this.showAlert = true;
                this.errMsg = 'Please enter your ID';
                return;
            }
            if ( this.password == '' ) {
                this.showAlert = true;
                this.errMsg = 'Please enter the password';
                return;
            }
            this.showAlert = false;
            document.frm.submit();
        }
    }
})