/**
 * Created by dinhv on 2/25/2017.
 */
$(function() {

    function toggleChevron(e) {
        $(e.target)
            .prev('.panel-heading')
            .find("i")
            .toggleClass('rotate-icon');
        $('.panel-body.animated').toggleClass('zoomIn zoomOut');
    }

    $('#accordion').on('hide.bs.collapse', toggleChevron);
    $('#accordion').on('show.bs.collapse', toggleChevron);
})

