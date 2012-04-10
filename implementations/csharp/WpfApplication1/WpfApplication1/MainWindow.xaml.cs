using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Globalization;
using System.Diagnostics;

namespace WpfApplication1
{
  /// <summary>
  /// Interaction logic for MainWindow.xaml
  /// </summary>
  public partial class MainWindow : Window
  {
    public MainWindow()
    {
      InitializeComponent();
    }

    private void button1_Click(object sender, RoutedEventArgs e)
    {
      var tf = new Typeface(new FontFamily("Arial"), FontStyles.Normal, FontWeights.Normal, FontStretches.Normal);
      var ft = new FormattedText("ff", CultureInfo.CurrentCulture, FlowDirection.LeftToRight, tf, 14, Brushes.Black);
      var g = ft.BuildGeometry(new Point(0, 0));
      var gc = (GeometryGroup)((GeometryGroup)g).Children[0];
      Debug.Assert(gc.Children.Count == ft.Text.Length, "Expected length of " + ft.Text.Length + " but found " + gc.Children.Count);

    }
  }
}
