INSERT INTO entity_tour (destination, price, duration_days, description, start_day, end_day, hotel_name, available_seats, transport)
VALUES 
('Đà Nẵng', 2000000, 3, 'Tour Bà Nà Hills', '2026-02-01', '2026-02-03', 'Sunrise Hotel', 20, 'Xe khách'),
('Hà Nội', 3000000, 2, 'Tour phố cổ', '2026-01-15', '2026-01-16', 'Hanoi Hotel', 15, 'Xe bus'),
('Nha Trang', 5000000, 5, 'Tour biển đảo', '2026-03-10', '2026-03-15', 'Nha Trang Resort', 10, 'Máy bay');
INSERT INTO entity_tour
(
    name_tour,
    name_tour_no_accent,
    destination,
    destination_no_accent,
    price,
    duration_days,
    description,
    description_no_accent,
    start_day,
    end_day,
    hotel_name,
    available_seats,
    transport
)
VALUES
(
    'Tour Đà Nẵng – Bà Nà Hills',
    'tour da nang ba na hills',
    'Đà Nẵng',
    'da nang',
    2000000,
    3,
    'Tham quan Bà Nà Hills, Cầu Vàng',
    'tham quan ba na hills cau vang',
    '2026-02-01',
    '2026-02-03',
    'Sunrise Hotel',
    20,
    'Xe khách'
),
(
    'Tour Hà Nội – Phố Cổ',
    'tour ha noi pho co',
    'Hà Nội',
    'ha noi',
    3000000,
    2,
    'Tham quan phố cổ Hà Nội',
    'tham quan pho co ha noi',
    '2026-01-15',
    '2026-01-16',
    'Hanoi Hotel',
    15,
    'Xe bus'
),
(
    'Tour Nha Trang – Biển Đảo',
    'tour nha trang bien dao',
    'Nha Trang',
    'nha trang',
    5000000,
    5,
    'Du lịch biển đảo Nha Trang',
    'du lich bien dao nha trang',
    '2026-03-10',
    '2026-03-15',
    'Nha Trang Resort',
    10,
    'Máy bay'
);
