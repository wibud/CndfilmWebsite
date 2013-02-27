$(document).ready(function(){
	// Load the classic theme
//	Galleria.loadTheme('./js/galleria.classic.min.js');
//
//	// Initialize Galleria
//	Galleria.run('#galleria');
//	
	//视频播放
	$('.media').media();
	
});

/**
 * isotope js
 * 
 */
$(function(){
    
    var $container = $('#container');

    $container.isotope({
      masonry: {
        columnWidth: 0
      },
      itemSelector : '.element'
      
    });
    
    var $optionSets = $('#filters'),
        $optionLinks = $optionSets.find('a');

    $optionLinks.click(function(){
      var $this = $(this);
      var $parentsLi = $this.parents('li');
      // don't proceed if already selected
      if ( $this.hasClass('selected') ) {
        return false;
      }
      var $optionSet = $this.parents('#filters');
      $optionSet.find('.active').removeClass('active');
      $parentsLi.addClass('active');

      // make option object dynamically, i.e. { filter: '.my-filter-class' }
      var options = {},
          key = $optionSet.attr('data-option-key'),
          value = $this.attr('data-option-value');
      // parse 'false' as false boolean
      value = value === 'false' ? false : value;
      options[ key ] = value;
      if ( key === 'layoutMode' && typeof changeLayoutMode === 'function' ) {
        // changes in layout modes need extra logic
        changeLayoutMode( $this, options )
      } else {
        // otherwise, apply new options
        $container.isotope( options );
      }
      
      return false;
    });

    
  });

