var World ={
    init: function(){
        var targetCollectionResource = new AR.TargetCollectionResource("magazine.wtc")
        var tracker = new AR.ImageTracker(targetCollectionResource);

        var img = new AR.ImageResource("imageOne.png");
        var drawable = new AR.ImageDrawable(img, 1, {
            translate: {
                x:-0.15
            }
        });

        var trackable = new AR.ImageTracker(tracker, "*", {
            drawables:{
                cam: drawable
            }
        });
    }
};

World.init();