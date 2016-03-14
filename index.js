
import React,{
  requireNativeComponent,
  Component,
  PropTypes,
  View
} from 'react-native';

export default class ImageViewCache extends Component {
  static propTypes = {
    ...View.propTypes,
    src: PropTypes.string,
    resizeMode : React.PropTypes.oneOf(["MATRIX","FIT_XY","FIT_START","FIT_CENTER","FIT_END","CENTER","CENTER_CROP","CENTER_INSIDE"]),
    oval: PropTypes.bool,
  };

  constructor(props) {
    super(props);
  }

  setNativeProps(nativeProps) {
  }

  _onChange(event: Event) {
    (this.props.onLoad && this.props.onLoad(event))
  }

  render() {
    return <ImageCacheView onChange={this._onChange.bind(this)} {...this.props} />;
  }
}

const ImageCacheView = requireNativeComponent('ImageViewCache', ImageViewCache, {
  nativeOnly: {onChange: true}
});

export const resizeModes = {
  /**
   * Scale using the image matrix when drawing. The image matrix can be set using
   * {@link ImageView#setImageMatrix(Matrix)}. From XML, use this syntax:
   * <code>android:scaleType="matrix"</code>.
   */
  matrix      : "MATRIX",
  /**
   * Scale the image using {@link Matrix.ScaleToFit#FILL}.
   * From XML, use this syntax: <code>android:scaleType="fitXY"</code>.
   */
  fitXy      : "FIT_XY",
  /**
   * Scale the image using {@link Matrix.ScaleToFit#START}.
   * From XML, use this syntax: <code>android:scaleType="fitStart"</code>.
   */
  fitStart   : "FIT_START",
  /**
   * Scale the image using {@link Matrix.ScaleToFit#CENTER}.
   * From XML, use this syntax:
   * <code>android:scaleType="fitCenter"</code>.
   */
  fitCenter  : "FIT_CENTER",
  /**
   * Scale the image using {@link Matrix.ScaleToFit#END}.
   * From XML, use this syntax: <code>android:scaleType="fitEnd"</code>.
   */
  fitEnd     : "FIT_END",
  /**
   * Center the image in the view, but perform no scaling.
   * From XML, use this syntax: <code>android:scaleType="center"</code>.
   */
  center      : "CENTER",
  /**
   * Scale the image uniformly (maintain the image's aspect ratio) so
   * that both dimensions (width and height) of the image will be equal
   * to or larger than the corresponding dimension of the view
   * (minus padding). The image is then centered in the view.
   * From XML, use this syntax: <code>android:scaleType="centerCrop"</code>.
   */
  centerCrop : "CENTER_CROP",
  /**
   * Scale the image uniformly (maintain the image's aspect ratio) so
   * that both dimensions (width and height) of the image will be equal
   * to or less than the corresponding dimension of the view
   * (minus padding). The image is then centered in the view.
   * From XML, use this syntax: <code>android:scaleType="centerInside"</code>.
   */
  centerInside : "CENTER_INSIDE",
}
