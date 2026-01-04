from flask import Flask, render_template, request, redirect, url_for, jsonify
from werkzeug.utils import secure_filename
from typing import Dict
import uuid
import os

app = Flask(__name__)


class Product:
    def __init__(self, pid: int, name: str, price: float, details: str, image: str):
        self.id = pid
        self.name = name
        self.price = price
        self.details = details
        self.image = image


IMAGES_UPLOAD_FOLDER = 'static/uploads/images'
ALLOWED_IMAGE_EXTENSIONS = {'png', 'jpg', 'jpeg', 'gif'}

app.config['IMAGES_UPLOAD_FOLDER'] = IMAGES_UPLOAD_FOLDER

products_db: Dict[int, Product] = {
    1: Product(
        pid=1,
        name="Gaming Laptop",
        price=1200.00,
        details="High performance laptop with RGB.",
        image="asus_tuf_f15.png"
    ),
    2: Product(
        pid=2,
        name="Wireless Mouse",
        price=45.50,
        details="Ergonomic mouse, very comfortable.",
        image="default.jpg"
    )
}

next_id = 3


# helpers
def is_file_allowed(filename: str) -> bool:
    return '.' in filename and filename.rsplit('.', 1)[1].lower() in ALLOWED_IMAGE_EXTENSIONS


def get_product_by_id(pid: int) -> Product | None:
    return products_db.get(pid)


@app.route('/')
def index():
    return render_template('index.html', products=products_db.values())


@app.route('/add', methods=['GET', 'POST'])
def add_product():
    global next_id

    if request.method == 'POST':
        p_name = request.form['name_input']
        p_price = float(request.form['price_input'])
        p_details = request.form['details_input']

        p_image = 'default.jpg'

        if 'product_image_file' in request.files:
            file = request.files['product_image_file']
            if file.filename:
                safe_name = secure_filename(file.filename)
                if is_file_allowed(safe_name):
                    # UUID for unique filenames
                    unique = uuid.uuid4().hex
                    filename = f"{unique}_{safe_name}"
                    file.save(os.path.join(app.config['IMAGES_UPLOAD_FOLDER'], filename))
                    p_image = filename

        new_product = Product(
            pid=next_id,
            name=p_name,
            price=p_price,
            details=p_details,
            image=p_image
        )

        products_db[next_id] = new_product
        next_id += 1

        return redirect(url_for('index'))

    return render_template('add_product.html')


@app.route('/product/<int:pid>')
def product_detail(pid):
    product = get_product_by_id(pid)
    if product:
        return render_template('product_details.html', product=product)
    return jsonify({"status": "error", "message": "Product not found"}), 404


@app.route('/delete/<int:pid>')
def delete_product(pid):
    if pid in products_db:
        del products_db[pid]
        return redirect(url_for('index'))
    return jsonify({"status": "error", "message": "Product not found"}), 404


if __name__ == '__main__':
    if not os.path.exists(IMAGES_UPLOAD_FOLDER):
        os.makedirs(IMAGES_UPLOAD_FOLDER)

    app.run(debug=True)
