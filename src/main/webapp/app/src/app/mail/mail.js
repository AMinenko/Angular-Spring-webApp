angular.module('ngBoilerplate.mail', ['ui.router'])
    .config(function ($stateProvider) {
        $stateProvider.state('mail', {
            url: '/mail',
            views: {
                'main': {
                    templateUrl: 'mail/mail.tpl.html',
                    controller: 'MailController'
                }
            },
            data: { pageTitle: 'Mail page' }
        });

    })

.controller("MailController", function ($scope, $http) {
        $scope.email = [];
        $scope.selectedMail = undefined;
        $scope.reply={};
        $scope.showingReply=false;

        $http({
            method: 'GET',
            url: '/basic-web-app/getAllMails'
            })
            .success(function (data, status, headers) {
                $scope.email=data;
            })
            .error(function (data, status, headers) {

         });

       $scope.sendReply = function(reply) {
           reply.sentAt = new Date();

           var data = {
             id:reply.id,
             from: reply.from,
             subject: reply.subject,
             sentAt: reply.sentAt,
             body:reply.body
           };

           $http.post('/basic-web-app/postMail', data).success(function(data,status,headers,config){
               console.log(data);
           });
       };

        $scope.setSelectedMail = function(mail){
            $scope.showingReply=false;
            $scope.selectedMail = mail;
            $scope.reply={};

        };

        $scope.isSelected = function(mail){
            if($scope.selectedMail){
                return $scope.selectedMail === mail;
            }
        };

        $scope.toggleReplyForm =  function(){
              $scope.showingReply=!$scope.showingReply;
              $scope.reply.to = $scope.selectedMail.from;
              $scope.reply.subject = "Re: "+ $scope.selectedMail.subject;
              $scope.reply.body = "\n---------------------------- \n\n" + $scope.selectedMail.body;

        };


       /* $scope.watch('selectedMail', function(evt){
           $scope.showingReply = false;
            $scope.reply = {};
        });*/


});