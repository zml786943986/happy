//用于eazyui 输入框字段校验
$.extend($.fn.validatebox.defaults.rules, {  
    //验证汉字  
    CHS: {  
        validator: function (value) {  
            return /^[\u0391-\uFFE5]+$/.test(value);  
        },  
        message: '只能输入中文'  
    },  
    //只能输入英文
    English: {  
        validator: function (value) {  
            return /^[a-zA-Z]+$/.test(value);  
        },  
        message: '只能输入字母'  
    },  
    //移动手机号码验证  
    Mobile: {//value值为文本框中的值  
        validator: function (value) {  
            var reg = /^1[3|4|5|8|9]\d{9}$/;  
            return reg.test(value);  
        },  
        message: '请输入正确手机号'  
    },  
    //国内邮编验证  
    ZipCode: {  
        validator: function (value) {  
            var reg = /^[0-9]\d{5}$/;  
            return reg.test(value);  
        },  
        message: '请输入正确邮政编码'  
    },  
  //6位数字
    Number: {  
        validator: function (value) {  
            var reg =/^[0-9]{6}$/;  
            return reg.test(value);  
        },  
        message: '请输入6位数字'  
    },  
    number: {  
        validator: function (value) {  
            var reg =/^[0-9]*$/;  
            return reg.test(value);  
        },  
        message: '只能输入数字'  
    }, 
    space: {  
        validator: function (value) {  
            var reg =/^[^\s]*$/;
            return reg.test(value);  
        },  
        message: '录入信息不能包含空格'  
    }, 
})  