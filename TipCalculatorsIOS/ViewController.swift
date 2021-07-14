import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var outputLabel: UILabel!
    @IBOutlet weak var tipButton: UIButton!
    @IBOutlet weak var reviewText: UITextField!
    @IBOutlet weak var tipText: UITextField!
    @IBOutlet weak var billText: UITextField!
    @IBAction func calculateTip(_ sender: Any) {
        if let tipPercent = Double(tipText.text!),
           let billAmount = Double(billText.text!) {
        let totalBill = Double(tipPercent*billAmount/100 + billAmount)
        outputLabel.text = String(totalBill)
        }
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        let tap: UIGestureRecognizer = UITapGestureRecognizer(target: self.view, action: #selector(UIView.endEditing))                
        view.addGestureRecognizer(tap)
    }
}

