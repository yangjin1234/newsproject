(function( $ ) {
	'use strict';

	$(function() {
		$('.color-picker').wpColorPicker();
	});

	$('#cw_enable_url').on('change', function(e) {
		$('#cw_announcement_url').val('');
		$('.cw_announcement_url').toggle();
	});

	$('#cw_is_announcement_closable').on('change', function(e) {
		$('.cw_closable_settings').toggle();
	});


})( jQuery );
