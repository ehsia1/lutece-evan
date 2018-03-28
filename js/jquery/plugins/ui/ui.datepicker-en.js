/* English initialisation for the jQuery UI date picker plugin. */
/* French version written by Keith Wood (kbwood@iprimus.com.au) and Stéphane Nahmani (sholby@sholby.net).
   Editted for English by Sofya Freyman */
jQuery(function($){
	$.datepicker.regional['en'] = {clearText: 'Clear', clearStatus: '',
		closeText: 'Close', closeStatus: 'Close without saving',
		prevText: '&lt;Prev', prevStatus: 'Previous month',
		nextText: 'Next&gt;', nextStatus: 'Next month',
		currentText: 'Current', currentStatus: 'Current month',
		monthNames: ['January','February','March','April','May','June',
		'July','August','September','October','November','December'],
		monthNamesShort: ['Jan','Feb','Mar','Apr','May','Jun',
		'Jul','Aug','Sep','Oct','Nov','Dec'],
		monthStatus: 'See different month', yearStatus: 'See different year',
		weekHeader: 'Wk', weekStatus: '',
		dayNames: ['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'],
		dayNamesShort: ['Sun','Mon','Tue','Wed','Thur','Fri','Sat'],
		dayNamesMin: ['Su','Mo','Tu','We','Th','Fr','St'],
		dayStatus: 'Use DD as the first day of the week', dateStatus: 'Choose the DD, MM d',
		dateFormat: 'dd/mm/yy', firstDay: 0,
		initStatus: 'Choose a date', isRTL: false};
	$.datepicker.setDefaults($.datepicker.regional['en']);
});
